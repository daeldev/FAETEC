<?php
    //verifica se o usuário está logado
    if(!isset($conexao_pdo) || !is_object($conexao_pdo)){
        exit('Erro na conexão com o banco de dados!!!');
    }
    // unir $_SESSION e $_POST para verificação
    if(isset($_POST) && !empty($_POST)){
        $dados_usuario = $_POST;
    }else {
        $dados_usuario = $_SESSION;
    }

    //verifica se os campos de usuário e senha existem e não estão em branco
    if(isset($dados_usuario['login'])&& isset($dados_usuario['senha'])
    && !empty($dados_usuario['login'])
    && !empty($dados_usuario['senha'])){
        //consultar na tabela de usuarios se o usuário existe
        $pdo_checa_user = $conexao_pdo->prepare("SELECT * FROM usuarios 
                                                 WHERE loginUsuario=? LIMIT 1");
        $verifica_pdo=$pdo_checa_user->execute(array($dados_usuario['login'])); 
        //verifica se a consulta foi realizada com sucesso
        if(!$verifica_pdo){
            $erro = $pdo_checa_user->errorInfo();
            exit($erro[2]);
        }
        //busca os dados da linha encontrada
        $fetch_usuario=$pdo_checa_user->fetch();
        
        //verifica se a senha do usuario esta correta
        if(crypt($dados_usuario['senha'],$fetch_usuario['senhaUsuario'])===$fetch_usuario['senhaUsuario']){
            //cria uma sessão no navegador para usuario logado
            $_SESSION['logado']         = true;
            $_SESSION['nome_sessao']    = $fetch_usuario['nomeUsuario'];
            $_SESSION['login_sessao']   = $fetch_usuario['loginUsuario'];
            $_SESSION['id_sessao']      = $fetch_usuario['idUsuario'];
        }else{
            // deslogar
            $_SESSION['logado'] = false;
            $_SESSION['login_erro'] = "Usuário ou Senha Incorreta!!!";           
        }
    }
?>