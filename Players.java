// Classe enumerada para definir ps players e os atributos de cada, foi escolhido o enum pois os dados não podem ser alterados
public enum Players {
  PLAYER1("Mario",4, 3, 3, 0),
  PLAYER2("Luigi",3, 4, 4, 0),
  PLAYER3("Peach", 3, 4, 2, 0),
  PLAYER4("Bowser", 5, 2, 5, 0),
  PLAYER5("Toad", 4, 5, 2, 0),
  PLAYER6("Yoshi", 2, 4, 3, 0);

  final String name;
  final int velocidade;
  final int manobrabilidade;
  final int poder;
  final int pontos;

  Players(String name, int velocidade, int manobrabilidade, int poder, int pontos) {
    this.name = name;
    this.velocidade = velocidade;
    this.manobrabilidade = manobrabilidade;
    this.poder = poder;
    this.pontos = pontos;
  }

  public String getName() {
    return name;
  }

  public int getVelocidade() {
    return velocidade;
  }

  public int getManobrabilidade() {
    return manobrabilidade;
  }

  public int getPoder() {
    return poder;
  }

  public int getPontos() {
    return pontos;
  }
}
