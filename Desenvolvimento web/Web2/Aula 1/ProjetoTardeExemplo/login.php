<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Turma 231 WEB2</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <form action="clientes.php" method="POST">
        <div align="center">
            <img src="img/logo_faetec.jpeg" width="300">
        </div>
        <div class="tela-login">
            <p class="titulo-login">PREENCHA OS DADOS DE ACESSO</P>
            <label>Login:
                <input type="text" name="login" size="28">
            </label>
            <label>Senha:
                <input type="password" name="senha" size="28">
            </label>   
            <label align="center">
                <input type="submit" value="Logar" class="botao">
            </label>               
        </div>
    </form>
</body>
</html>