package kz.iitu.bank.test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

public class ClientDaoImpl extends JdbcDaoSupport implements ClientDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insertClient(Client cl) {
        String sql = "INSERT INTO clients " +
                "(clientID, client_name, phoneNum, cardNum, expirationDate, CVV," +
                "pin, money) VALUES (?, ?, ?, ?, ?, ?, ?, ?,)" ;
        getJdbcTemplate().update(sql, cl.getClient_id(), cl.getName(), cl.getPhone_num(), cl.getCard_num(), cl.getExp_date(),
                cl.getCvv(), cl.getPin(), cl.getCash());
    }

    @Override
    public void insertClients(List<Client> clients) {
        String sql = "INSERT INTO clients " +  "(clientID, client_name, phoneNum, cardNum, expirationDate, CVV," +
                "pin, money) VALUES (?, ?, ?, ?, ?, ?, ?, ?,)" ;
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Client client = clients.get(i);
                ps.setInt(1, client.getClient_id());
                ps.setString(2, client.getName());
                ps.setString(3, client.getPhone_num());
                ps.setString(4, client.getCard_num());
                ps.setString(5, client.getExp_date());
                ps.setString(6, client.getCvv());
                ps.setString(7, client.getPin());
                ps.setDouble(8, client.getCash());

            }

            public int getBatchSize() {
                return clients.size();
            }
        });
    }

    @Override
    public List<Client> getAllClients() {
        String sql = "SELECT * FROM clients";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Client> result = new ArrayList<Client>();
        for(Map<String, Object> row:rows){
            Client cl = new Client();
            cl.setClient_id((int)row.get("clientID"));
            cl.setName((String)row.get("client_name"));
            cl.setPhone_num((String)row.get("phoneNum"));
            cl.setCard_num((String)row.get("carNum"));
            cl.setExp_date((String)row.get("expirationDate"));
            cl.setCvv((String)row.get("CVV"));
            cl.setPin((String)row.get("pin"));
            cl.setCash((Double)row.get("money"));
            result.add(cl);
        }

        return result;
    }

    @Override
    public Client getClientById(String clientId) {
        String sql = "SELECT * FROM employee WHERE empId = ?";
        return (Client) getJdbcTemplate().queryForObject(sql, new Object[]{clientId}, new RowMapper<Client>(){
            @Override
            public Client mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Client cl = new Client();
                cl.setClient_id(rs.getInt("clientID"));
                cl.setName(rs.getString("client_name"));
                cl.setPhone_num(rs.getString("phoneNum"));
                cl.setCard_num(rs.getString("carNum"));
                cl.setExp_date(rs.getString("expirationDate"));
                cl.setCvv(rs.getString("CVV"));
                cl.setPin(rs.getString("pin"));
                cl.setCash(rs.getDouble("money"));
                return cl;
            }
        });
    }
}
