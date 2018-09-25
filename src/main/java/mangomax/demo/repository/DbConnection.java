package mangomax.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DbConnection implements IDbRepository {

    @Autowired
    JdbcTemplate jdbc;

    SqlRowSet sqlRowSet;

    @Override
    public boolean test() {
        List<String> test = new ArrayList<>();

        String sql = "SELECT * FROM test_table";
        sqlRowSet = jdbc.queryForRowSet(sql);

        while (sqlRowSet.next()){
            test.add(sqlRowSet.getString("value"));
        }

        if (test.size() > 0){
            return true;
        }
        return false;
    }
}
