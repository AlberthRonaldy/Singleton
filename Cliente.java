public class Cliente {
    private String id;
    private String nome;
    private AccountManager accountManager;

    public Cliente(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.accountManager = AccountManager.getInstance();
        accountManager.criarConta(id, 0.0); // Cria uma conta com saldo inicial 0
    }

    public void depositar(double valor) {
        accountManager.depositar(id, valor);
    }

    public void sacar(double valor) {
        accountManager.sacar(id, valor);
    }

    public void verSaldo() {
        double saldo = accountManager.verSaldo(id);
        System.out.println("Saldo de " + nome + " (ID: " + id + "): R$" + saldo);
    }
}