import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static AccountManager instance;
    private Map<String, Double> contas;

    private AccountManager() {
        contas = new HashMap<>();
    }

    // Método para obter a instância única de AccountManager
    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public void criarConta(String contaId, double saldoInicial) {
        if (!contas.containsKey(contaId)) {
            contas.put(contaId, saldoInicial);
            System.out.println("Conta criada com sucesso para ID: " + contaId);
        } else {
            System.out.println("Conta já existe para ID: " + contaId);
        }
    }

    public void depositar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            contas.put(contaId, contas.get(contaId) + valor);
            System.out.println("Depositado R$" + valor + " na conta " + contaId);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            double saldoAtual = contas.get(contaId);
            if (saldoAtual >= valor) {
                contas.put(contaId, saldoAtual - valor);
                System.out.println("Saque de R$" + valor + " realizado na conta " + contaId);
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public double verSaldo(String contaId) {
        return contas.getOrDefault(contaId, 0.0);
    }

    public void listarContasAtivas() {
        System.out.println("Contas ativas:");
        contas.forEach((id, saldo) -> System.out.println("Conta ID: " + id + ", Saldo: R$" + saldo));
    }
}
