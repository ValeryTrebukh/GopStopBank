package com.elesson.gopstopbank;

import com.elesson.gopstopbank.model.Account;
import com.elesson.gopstopbank.model.Bank;
import com.elesson.gopstopbank.model.Client;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

    private static Map<Integer, Account> accounts = new HashMap<>();
    private static Map<Integer, Client> clients = new HashMap<>();
    private static Map<Integer, Bank> banks = new HashMap<>();

    static {
        Client joe = new Client("Joe");
        Client jeem = new Client("Jeem");
        clients.put(joe.getId(), joe);
        clients.put(jeem.getId(), jeem);

        Bank gp = new Bank("GopStop");

        Account joeAc = new Account(new Client("Joe").getId(), gp.getId());
        Account jeemAc = new Account(new Client("Jeem").getId(), gp.getId());
        Account jennieAc = new Account(new Client("Jennie").getId(), gp.getId());
        accounts.put(joeAc.getId(), joeAc);
        accounts.put(jeemAc.getId(), jeemAc);
        accounts.put(jennieAc.getId(), jennieAc);
    }

    public static Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public static Map<Integer, Client> getClients() {
        return clients;
    }

    public static Map<Integer, Bank> getBanks() {
        return banks;
    }
}
