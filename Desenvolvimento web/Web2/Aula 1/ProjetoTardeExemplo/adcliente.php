<?php
    include("conexao.php");
    include("login/verifica_login.php");
    include("login/redireciona_login.php");

    $usuario = $_SESSION['nome_sessao'];
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Turma 231</title>
    <style>
        .required:after{
            content:" *";
            color:red;
        }
    </style>  
    <script type="text/javascript">
        $(document).ready(function(){
            $('#name').focus();
            $(document).find('input').keypress(function(e)){
                if (e.which==13){
                    e.preventDefault();
                    $(this).closest('.item')
                    .next().first()
                    .find('input')
                    .focus();
                }
            }
        });
    </script>
</head>
<body>
    <p>Usuário Logado: <?php echo $usuario;?></p>
    <a href="clientes.php?set=ad" title="Novo Cliente">
        <img src="img/voltar.png" width="150" height="50">
    </a>
    &nbsp;    
    <h1>CADASTRAR NOVO CLIENTE</h1>
    <form action="acao/cliente.php" method="POST">
        <label class="required">Nome:<input name="nome" type="text" size="55" required autofocus="true"></label><br><br>
        <label class="required">Telefone:<input name="tel" type="text" size="15" required></label><br><br>
        <label class="required">E-Mail:<input name="email" type="email" size="45" required></label><br><br>
        <div align="center">
            <input type="hidden" name="set" value="ad">    
            <input type="submit" value="Salvar Registro">
        </div>
    </form>
</body>
</html>