<?php
    if($_SESSION['logado']!=true){
        //envia mensagem e retorna a tela de login
        echo "<script>alert('Erro na autenticação do usuário!')</script>";
        echo "<script>location.href='login.html'</script>";
    }
?>