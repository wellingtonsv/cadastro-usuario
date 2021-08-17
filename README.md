# cadastro-usuario (LEGADO).
    Sistema responsável por manter usuários com login.

## RODAR O PROJETO

## TECNOLOGIAS E FRAMEWORKS
    - Java 6.
    - JSP.
    - Hibernate 3.0
    - Servlet.
    - JPA 2.0
    - MSQL mini 11
    - BDD

# REGRA DE NEGÓCIO REGISTRO USUÁRIO (BDD)
    RN01 - O usuario novo.
    DADO - usuário novo no sistema
    QUANDO - usuario clica no link "Se register aqui !!!"
    E - informa seus dados corretamente(Primeiro Nome, Sobre Nome, Ultimo Nome, Email, profile, Login, Senha)
    ENTÃO - o sistema deve exibir a tela com uma mensagem "Obrigado por se cadastrar"
    E - um link para retorna para tela de login "Para eftuar um novo Login e Senha Click aqui !!!"

    RN02 - O usuario já cadastrado.
    DADO - usuário ja cadastrado no sistema
    QUANDO - informar suas credencias corretas
    ENTÃO - o sistema deve exibir a tela com todos os seus dados.

    RN03 - Login valido
    DADO - um usuário ja cadastrado no sistema
    QUANDO - usuario informa seu login corretamente(Login e Senha)
    ENTAO - o sistema deve mostrar a pagina principal
    E - uma lista com todos usuario cadastrado no sistema.

    RN04 - Login invalido
    DADO - um usuario ja cadastrado no sistema ou não.
    QUANDO - usuario informar suas credencias invalidas
    ENTAO - o sistema deve mostar uma tela de erro com menssagem ao tentar se logar
    E - mostar link para tela de login.

    RN05 - Logof do usuario
    DADO - um usuario ja logado no sistema
    QUANDO - o usuario clica no link sair
    ENTAO - o sistema deve mostar a tela de logof
    E - mostar um link para tela de login.

    RN06 - Excluir usuario com perfil de administrador
    DADO - um usuario já cadastrado no sistema 
    E - logado no sistema, com perfil de "Admin"
    QUANDO - usuario clica no botão excluir
    ENTAO - o sistema deve mostar um mensagem de confirmação da ação, se usuario optar por sim o sistema deve excluir com sucesso o usuario
    E - o sistema deve mostar uma tela com link para voltar para tela anterior.

    RN07 - Excluir usuario com perfil de usuario padrao
    DADO - um usuario já cadastrado no sistema 
    E - logado no sistema, com perfil de "padrao"
    QUANDO - usuario clica no botão excluir
    ENTAO - o sistema deve mostar um mensagem de confirmação da ação, se usuario optar por sim o sistema nao deve excluir o usuario
    E - o sistema deve mostar uma tela com link para voltar para tela anterior.

#cadastro-usuario

