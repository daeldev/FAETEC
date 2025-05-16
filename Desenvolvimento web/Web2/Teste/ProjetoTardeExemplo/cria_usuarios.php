<?php
// Inclui o arquivo de conexão com o banco
include("conexao.php");

// Função para apagar usuário
if (isset($_GET['del'])){
    // Deleta usuario sem confirmação
    $deleta_pdo=$conexao_pdo->prepare("DELETE FROM usuarios WHERE idUsuario=?");
    $deleta_pdo->execute(array($_GET['del']));
    // Redireciona para a tela principal
    header('location: cria_usuarios.php');
}

// Verifica se algo foi postado para puclicar ou editar
if(isset($_POST)&& !empty($_POST)){
    // Cria as variáveis
    $idUsuario=$_POST["idUsuario"];
    $nome=$_POST["form_usuario"];
    $login=$_POST["form_login"];
    $senha=$_POST["form_senha"];

    // Verifica se o usuário já existe na tabela
    $verifica_pdo = $conexao_pdo->prepare("SELECT * FROM usuarios WHERE idUsuario=?");
    $verifica_pdo->execute(array($idUsuario));

    // Captura os dados da linha
    $idUsuario = $verifica_pdo->fetch();
    $idUsuario = $idUsuario["idUsuario"];

    // Verifica se tem algum erro
    if (!$erro){
        // Se o usuário existir, atualiza
        if (! empty($idUsuario)){
            $altera_pdo=$conexao_pdo->prepare("UPDATE usuarios 
                                               SET  nomeUsuario=?,
                                                    loginUsuario=?,
                                                    senhaUsuario=?
                                               WHERE idUsuario=?");
            $altera_pdo->execute(array($nome,$login,crypt($senha,'rl'),$idUsuario));
        // Se o usuário não existir
        } else {
            $insere_pdo=$conexao_pdo->prepare("INSERT INTO usuarios (nomeUsuario,loginUsuario,senhaUsuario)
                                                VALUES(?,?,?)");
            $insere_pdo->execute(array($nome,$login,crypt($senha,'rl')));
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>USUARIOS</title>
    <link rel="stylesheet" href="css/cria_usuario.css">
</head>
<body>
    <p>Para editar, apenas digite o nome de usuário que deseja editar</p>
    <p><a href="login.html">Clique aqui para testar</a></p>
    <form action="" method="POST">
        <table>
            <tr><td>ID:</td><td><input type="text" name="idUsuario" required></td></tr>
            <tr><td>Usuário:</td><td><input type="text" name="form_usuario" required></td></tr>
            <tr><td>Login:</td><td><input type="text" name="form_login" required></td></tr>
            <tr><td>Senha:</td><td><input type="password" name="form_senha" required></td></tr>
            <tr><td><input type="submit" value="Registrar"</td></tr>
        </table>
    </form>
    <?php
        // Mostra os usuaŕio já cadastrados
        $usuarios_pdo=$conexao_pdo->prepare("SELECT * FROM usuarios ORDER BY idUsuario DESC");
        $usuarios_pdo->execute();
    ?>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>NOME</th>
            <th>LOGIN</th>
            <th>SENHA</th>
        </tr>
        <?php
        WHILE($rs=$usuarios_pdo->fetch()){
            echo "<tr>";
            echo "<th>".$rs['idUsuario']."</th>";
            echo "<th>".$rs['nomeUsuario']."</th>";
            echo "<th>".$rs['loginUsuario']."</th>";
            echo "<th>".$rs['senhaUsuario']."</th>";
            echo "</tr>";
        }
        ?>
    </table>
</body>
</html>