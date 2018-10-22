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
        joe.assignId();
        Client jeem = new Client("Jeem");
        jeem.assignId();
        clients.put(joe.getId(), joe);
        clients.put(jeem.getId(), jeem);

        Bank gp = new Bank("GopStop");
        gp.assignId();
        banks.put(gp.getId(), gp);

        Account joeAc = new Account(joe.getId(), gp.getId());
        joeAc.assignId();
        Account jeemAc = new Account(jeem.getId(), gp.getId());
        jeemAc.assignId();
        Account jeemAc2 = new Account(jeem.getId(), gp.getId());
        jeemAc2.assignId();
        accounts.put(joeAc.getId(), joeAc);
        accounts.put(jeemAc.getId(), jeemAc);
        accounts.put(jeemAc2.getId(), jeemAc2);
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
