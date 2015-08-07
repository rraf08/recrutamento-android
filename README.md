# Mockup

![mockup](https://raw.githubusercontent.com/Movile/recrutamento-android/master/listagem-episodios-da-temporada.png "Mockup")

# App (pt-br)
## Descrição

Crie um app Android que mostre uma listagem de episódios de uma temporada específica de uma série. Acima dessa listagem exiba um cabeçalho com algumas informações da série (thumbnail da capa da série) e também da temporada (imagem da temporada e avaliação). Tanto a série quanto a temporada usada podem ser parâmetros fixos no código, ou seja, não precisa criar nenhuma outra tela para que essa escolha seja dinâmica.

Para isso você deverá utilizar a API do [Trakt](https://trakt.tv) (você deve se registrar no site para ter acesso à API) e também os assets disponibilizados.

A prova foi pensada para ser feita em no máximo 4 horas e você deve utilizar o mockup acima como base para seu desenvolvimento.

## Requisitos
* Deverá ser feito usando o Android Studio e Gradle
* Funcionar a partir do Android 4.1 (API 16)
* Deverá ser testado nas imagens dos seguintes dispositivos (usar genymotion 2.5 para os testes):
  * Google Nexus 6 - Android 5.1.1
  * Galaxy S5 - Android 5.0
  * Motorola Moto X - Android 4.4.4
  * Google Nexus 4 - Android 4.3
  * Sony Xperia S - Android 4.1.1
* É permitido o uso de bibliotecas externas

## Extras

* Tratamento de cenários de erro (ausência de conexão, erros do servidor)
* Feedbacks de carregamento
* Efeito de parallax no cabeçalho
* Tornar a toolbar opaca conforme o scroll da listagem de episódios
* Testes automatizados
* Layout diferente para tablet ou orientação landscape

## Submissão

Você tem duas opções:  

1) Você pode fazer um _pull request_ no nosso [repositório __público__](https://github.com/Movile/recrutamento-android). Note que seu *fork* ficará público para qualquer pessoa ver.

2) Caso você prefira um pouco de privacidade, crie um repositório com o nome **recrutamento-android** na sua conta do GitHub ou Bitbucket, inclua o usuário recruitment-android-movile como colaborador (pode ser acesso só para leitura) e mande um email para recruitment.android@movile.com avisando.

# App (en)
## Description

Create an Android app that shows a list of episodes from a serie’s season. Above that episodes list create a header that displays some informations about the serie (cover thumbnail) and also the season (banner and rating). It’s important to notice that both serie and season can be chosen as you like and can be fixed in the code, which means that you don’t have to create any other screen to make this choice dynamic.

In order to create this app you will use the [Trakt](https://trakt.tv) API (you must sign up in the website to have access to the API) and also the assets we provided.

This test was designed to be developed in at most 4 hours and you should use the mockup above as base for your development.

## Requirements
* You must use Android Studio and Gradle
* Your app must work since Android 4.1 (API 16)
* It must be tested in the following device’s images (use Genymotion 2.5 to run your tests):
  * Google Nexus 6 - Android 5.1.1
  * Galaxy S5 - Android 5.0
  * Motorola Moto X - Android 4.4.4
  * Google Nexus 4 - Android 4.3
  * Sony Xperia S - Android 4.1.1
* It’s allowed to use external libraries

## Extras

* Handle error scenarios (no connectivity, server errors)
* Loading feedback
* Parallax effect on header scroll
* Transform the toolbar in a opaque color during scroll
* Automated tests
* Different layout for tablet or landscape orientation

## Submission

You have two options:  

1) Create a _pull request_ to our [__public__ repository](https://github.com/Movile/recrutamento-android). Note that your *fork* will be public for anyone to see.

2) In case you prefer some privacy, create a repository with the name **recrutamento-android** in your GitHub or Bitbucket account, add the user recruitment-android-movile as a collaborator (read-only access is enough) and send an email to recruitment.android@movile.com to let us know.
