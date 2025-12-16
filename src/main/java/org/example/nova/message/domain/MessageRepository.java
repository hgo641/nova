package org.example.nova.message.domain;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

@Repository
public class MessageRepository {

    private final DataSource dataSource;

    public MessageRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Message findById(Long id) {
        String sql = """
                    SELECT id, message, created_at
                    FROM message
                    WHERE id = ?
                """;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new NoSuchElementException("메시지가 존재하지 않습니다. id=" + id);
                }

                return new Message(
                        rs.getLong("id"),
                        rs.getString("message"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long createMessage(Message message) {
        String sql = """
                    INSERT INTO message (message)
                    VALUES (?)
                """;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, message.getMessage());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
                throw new SQLException("ID 생성 실패");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
