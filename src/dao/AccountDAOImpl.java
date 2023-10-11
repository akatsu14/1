package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import data.Account;

public class AccountDAOImpl implements DataRepository<Account> {

    private List<Account> accounts;
    private final String DATA_SOURCE;

    public AccountDAOImpl(String dataSource) throws IOException {
        this.DATA_SOURCE = dataSource;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.DATA_SOURCE));
        accounts = bufferedReader.lines()
            .skip(1)
            .map(line -> {
                String[] temp = line.split(",");
                return new Account(temp[0], temp[1], temp[2]);
            }).toList();
        bufferedReader.close();
    }

    @Override
    public boolean deleteById(String accountId) throws IOException {
        boolean isSuccess = accounts.removeIf(e -> e.getId().equals(accountId));
        if (isSuccess) {
            this.saveAll();
            return true;
        }
        return false;
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public Optional<Account> findById(String accountId) {
        return accounts.stream().filter(e -> e.getId().equals(accountId)).findAny();
    }

    @Override
    public boolean save(Account account) throws IOException {
        if (accounts.stream().anyMatch(e -> e.getId().equals(account.getId()))) {
            return false;
        } else {
            accounts.add(account);
            this.saveAll();
            return true;
        }
    }

    @Override
    public void saveAll() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.DATA_SOURCE));
        bufferedWriter.write("id,password,role");
        bufferedWriter.newLine();
        accounts.forEach(e -> {
            try {
                bufferedWriter.write(e.getId()+","+e.getPassword()+","+e.getRole());
                bufferedWriter.newLine();
            } catch (IOException e1) {
                System.out.println("Writer get error!");
            }
        });
        bufferedWriter.close();
    }

}
