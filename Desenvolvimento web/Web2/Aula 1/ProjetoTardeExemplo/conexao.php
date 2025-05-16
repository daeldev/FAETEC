<?php
    //define o limite de tempo da sessão em 60 minutos
    session_cache_expire(60);
    //Inicia a sessão
    session_start();
    //variavel que verifica se o usuário está logado
    if(!isset($_SESSION['logado'])) {
        $_SESSION['logado']=false;
    }
    //Erro do login
    $_SESSION['login_erro']=false;


    // variável recebe o nome do servidor do banco
    $host_db = "localhost";
    // variável recebe o nome do usuário no servidor
    $usuario_db = "root";
    // variável recebe a senha do usuário no servidor
    $senha_db = "";
    // variável recebe o nome do banco de dados
    $banco = "Bd231";
    // variável recebe o sistema de conversão de caracteres
    $charset_db = "UTF8";

    $conexao_pdo = null;

    $detalhes_pdo = "mysql:host=".$host_db.";";
    $detalhes_pdo.= "dbname=".$banco.";";
    $detalhes_pdo.= "charset=".$charset_db.";";

    // Tentar conectar-se ao banco
    try{
        // cria a conexão PDO com a base de dados
        $conexao_pdo = new PDO($detalhes_pdo,$usuario_db,$senha_db);
        //echo "Banco de Dados Conectado com Sucesso!!!";
    } catch (PDOException $e){
        // se algo der errado mostra o erro PDO
        print "Erro: ". $e->getMessage()."<br>";

        // Mara o script
        die();
    }
?>