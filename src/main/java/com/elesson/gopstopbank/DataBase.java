package com.elesson.gopstopbank;

import com.elesson.gopstopbank.model.Bank;
import com.elesson.gopstopbank.model.BankAccount;
import com.elesson.gopstopbank.model.Client;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

    private static Map<Integer, Client> clients = new HashMap<>();
    private static Map<Integer, Bank> banks = new HashMap<>();
    private static Map<Integer, BankAccount> bankAccounts = new HashMap<>();

    static {
        Client joe = new Client("Joe");
        joe.assignId();
        Client jeem = new Client("Jeem");
        jeem.assignId();
        clients.put(joe.getId(), joe);
        clients.put(jeem.getId(), jeem);

        Bank gp = new Bank("GopStop");
        gp.assignId();
        banks.put(gp.getId(), gp);

        BankAccount joeBa = new BankAccount(joe.getId());
        joeBa.assignId(gp);
        bankAccounts.put(joeBa.getId(), joeBa);

        BankAccount jeemBa = new BankAccount(jeem.getId());
        jeemBa.assignId(gp);
        bankAccounts.put(jeemBa.getId(), jeemBa);

        BankAccount jeemBa2 = new BankAccount(jeem.getId());
        jeemBa2.assignId(gp);
        bankAccounts.put(jeemBa2.getId(), jeemBa2);
    }


    public static Map<Integer, Client> getClients() {
        return clients;
    }

    public static Map<Integer, Bank> getBanks() {
        return banks;
    }

    public static Map<Integer, BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
