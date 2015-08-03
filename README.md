# App

Crie um app Android que mostre uma listagem de episódios de uma temporada específica de uma série. Acima dessa listagem exiba um cabeçalho com algumas informações da série (thumbnail da capa da série) e também da temporada (imagem da temporada e avaliação). Tanto a série quanto a temporada usada podem ser parâmetros fixos no código, ou seja, não precisa criar nenhuma outra tela para que essa escolha seja dinâmica.

Para isso você deverá utilizar a API do [Trackt](https://trakt.tv) (você deve se registrar no site para ter acesso à API) e também os assets disponibilizados.

A prova foi pensada para ser feita em no máximo 4 horas e você deve utilizar o mockup abaixo como base para seu desenvolvimento:

![mockup](https://raw.githubusercontent.com/Movile/recrutamento-android/master/listagem-episodios-da-temporada.png "Mockup")

# Requisitos
* Deverá ser feito usando o Android Studio e Gradle
* Funcionar a partir do Android 4.1 (API 16)
* Deverá ser testado nas imagens dos seguintes dispositivos (usar genymotion 2.5 para os testes):
  * Google Nexus 6 - Android 5.1.1
  * Galaxy S5 - Android 5.0
  * Motorola Moto X - Android 4.4.4
  * Google Nexus 4 - Android 4.3
  * Sony Xperia S - Android 4.1.1
* É permitido o uso de bibliotecas externas

# Extras

* Tratamento de cenários de erro (ausência de conexão, erros do servidor)
* Feedbacks de carregamento
* Efeito de parallax no cabeçalho
* Tornar a toolbar opaca conforme o scroll da listagem de episódios
* Testes automatizados
* Layout diferente para tablet ou orientação landscape

# Submissão

Você tem duas opções:  

1) Você pode fazer um _pull request_ no nosso [repositório __público__](https://github.com/Movile/recrutamento-android). Note que seu *fork* ficará público para qualquer pessoa ver.

2) Caso você prefira um pouco de privacidade, crie um repositório com o nome **recrutamento-android** na sua conta do GitHub ou Bitbucket, inclua o usuário recruitment-android-movile como colaborador (pode ser acesso só para leitura) e mande um email para recruitment.android@movile.com avisando.
