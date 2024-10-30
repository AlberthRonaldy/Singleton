public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("001", "Alice");
        Cliente cliente2 = new Cliente("002", "Bob");

        // Operações com o cliente1
        cliente1.depositar(1000.0);
        cliente1.verSaldo();

        // Operações com o cliente2
        cliente2.depositar(500.0);
        cliente2.sacar(100.0);
        cliente2.verSaldo();

        // Verificar se todos estão usando a mesma instância do AccountManager
        AccountManager manager = AccountManager.getInstance();
        manager.listarContasAtivas();

        // Testando novamente com múltiplas instâncias
        Cliente cliente3 = new Cliente("003", "Carlos");
        cliente3.depositar(300.0);
        manager.listarContasAtivas();

        // Confirmação de que a instância é única
        AccountManager manager2 = AccountManager.getInstance();
        System.out.println("Mesma instância? " + (manager == manager2)); // Deve imprimir true
    }
}
