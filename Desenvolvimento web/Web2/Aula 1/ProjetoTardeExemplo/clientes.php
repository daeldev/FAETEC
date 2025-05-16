<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Turma 231</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<?php
    include("conexao.php");
    include("login/verifica_login.php");
    include("login/redireciona_login.php");

    $usuario = $_SESSION['nome_sessao'];
    $login   = $_SESSION['login_sessao'];

    if(isset($_GET['busca'])) {
        $busca=$_GET['busca'];
    } else {
        $busca='';
    }
?>
<body>
    <p>Usuário Logado: <?php echo $login." - Nome: ".$usuario;?></p>
    <h1>CADASTRO DE CLIENTES</h1>
    <a href="adcliente.php?set=ad" title="Novo Cliente">
        <img src="img/Novo.jpg" width="50" height="50">
    </a>
    &nbsp;
    <a href="rptclientes.php" title="Imprimir Relatório de Clientes">
        <img src="img/print.png" width="65" height="50">
    </a>    
    &nbsp;
    <a href="login/sair_login.php" title="Fazer Logoff">
        <img src="img/sair.png" width="50" height="50">
    </a>       
    <br><br>
    <form action="clientes.php" method="GET">
        <label>Digite o código ou nome:
            <input type="text" name="busca" size="30">
            <input type="submit" value="PESQUISAR" class="botao">
        </label>
    </form>
    <br><br>
    <table width="100%" border="1" cellspacing="0">
        <tr bgcolor="fffff0">
            <td width="5%">ID</td>
            <td width="40%">NOME</td> 
            <td width="15%">TELEFONE</td> 
            <td width="25%">E-Mail</td>
            <td width="15%">AÇÃO</td>
        </tr>
        <?php
            $verifica_pdo = $conexao_pdo->prepare("SELECT * FROM clientes 
                                                   WHERE nomeCliente
                                                   LIKE '$busca%'
                                                   OR idCliente='$busca'
                                                   ORDER BY nomeCliente");
            $verifica_pdo->execute();
            while($rs=$verifica_pdo->fetch()){
        ?>
        <tr>
            <td width="5%"><?php echo $rs["idCliente"];?></td>
            <td width="40%"><?php echo $rs["nomeCliente"];?></td> 
            <td width="15%"><?php echo $rs["telCliente"];?></td> 
            <td width="25%"><?php echo $rs["emailCliente"];?></td>
            <td width="15%" align="center">
                <a href="upcliente.php?id=<?php echo $rs['idCliente'];?>" title="Editar Cliente">
                    <img src="img/edit.png" width="30" height="30">
                </a>
                &nbsp;&nbsp;
                <a href="acao/cliente.php?id=<?php echo $rs['idCliente'];?>&set=del"
                    onclick="return confirm('Confirma exclusão do registro?')" title="Ecluir Cliente">
                    <img src="img/delete.jpg" width="30" height="30">
                </a>
            </td>
        </tr>
        <?php
            }
        ?>
    </table>  
</body>
</html>