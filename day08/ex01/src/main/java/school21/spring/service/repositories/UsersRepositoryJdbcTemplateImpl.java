package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository<User>{
    private DataSource dataSource;

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public RowMapper<User> rowMapper = (rs, rowNum) -> {
        User user = new User();

        user.setIdentifier(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        return user;
    };

    @Override
    public User findById(Long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        List<User> userList = jdbcTemplate.query("SELECT * FROM users WHERE id = ?", rowMapper, id);
        if (!userList.isEmpty())
            return userList.get(0);
        return null;
    }

    @Override
    public List<User> findAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        List<User> userList = jdbcTemplate.query("SELECT * FROM users", rowMapper);
        return userList;
    }

    @Override
    public void save(User entity) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        String sql = "INSERT INTO public.users (id, email) VALUES (:id, :email)";
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(entity.getId()));
        params.put("email", entity.getEmail());

        template.update(sql, params);
    }

    @Override
    public void update(User entity) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        String sql = "UPDATE public.users SET email= :email WHERE id = :id";
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(entity.getId()));
        params.put("email", entity.getEmail());

        template.update(sql, params);
    }

    @Override
    public void delete(Long id) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        String sql = "DELETE from public.users WHERE id = :id";
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));

        template.update(sql, params);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
