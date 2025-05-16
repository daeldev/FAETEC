<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Turma 231</title>
</head>
<body>
    <?php
        include("conexao.php");
        include("login/verifica_login.php");
        include("login/redireciona_login.php");
    
        $usuario = $_SESSION['nome_sessao'];
        $login   = $_SESSION['login_sessao'];
        
        $id=$_GET['id'];
        include("conexao.php");
        $verifica_pdo = $conexao_pdo->prepare("SELECT * FROM clientes WHERE idCliente=?");
        $verifica_pdo->execute(array($id));
        $rs=$verifica_pdo->fetch();
    ?>
    <p>Usuário Logado: <?php echo $usuario;?></p>
    <a href="clientes.php?set=ad" title="Novo Cliente">
        <img src="img/logoff.png" width="50" height="50">
    </a>
    &nbsp;     
    <h1>ALTERAÇÃO CADASTRAL DE CLIENTE</h1>
    <form action="acao/cliente.php" method="POST">
        <label>
            Código:<input name="id" type="text" readonly="true" size="5" value="<?php echo $id;?>">
        </label><br><br>
        <label>
            Nome:<input name="nome" type="text" size="55" value="<?php echo $rs['nomeCliente'];?>">
        </label><br><br>
        <label>
            Telefone:<input name="tel" type="text" size="15" value="<?php echo $rs['telCliente'];?>">
        </label><br><br>
        <label>
            E-Mail:<input name="email" type="text" size="45" value="<?php echo $rs['emailCliente'];?>">
        </label><br><br>
        <div align="center">
            <input type="hidden" name="set" value="up">
            <input type="submit" value="Salvar Registro">
        </div>
    </form>    
</body>
</html>