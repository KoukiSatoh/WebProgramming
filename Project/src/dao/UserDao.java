package dao;
// とりあえず見本をコピペしただけなのであとでよく読んで、内容を理解する。
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

/**s
 * ユーザテーブル用のDao
 * @author satoh
 *
 */
public class UserDao {

    /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    /*userテーブルにあるIDの値がidであるユーザを取り出すメソッド
     * @id ID
     * */
    public User findByDetail(String id) {//
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            int idDate = rs.getInt("id");
            String loginIdData = rs.getString("login_id");
            String name = rs.getString("name");
            Date birthDate = rs.getDate("birth_date");
            String password = rs.getString("password");
            String createDate = rs.getString("create_date");
            String updateDate = rs.getString("update_date");
            return new User(idDate, loginIdData, name, birthDate, updateDate, createDate, updateDate);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

   /*IDとユーザ名と生年月日と更新日時を受け取り、ユーザ情報を更新する
    * @param name ユーザ名
    * @param password  パスワード
    * @param birthDate 生年月日
    * @param id ID
    */
    public static void findByUpdate(String password,String name,String birthDate, String id ) {//更新
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // UPDATE文を準備
            String sql = "UPDATE user SET  password = ?, name = ?, birthDate = ? WHERE id = ? ";

             // UPDATEを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, password );
            pStmt.setString(2, name);
            pStmt.setString(3, birthDate);
            pStmt.setString(4, id);

            // UPDATEを実行
            int result = pStmt.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*暗号化されたパスワード、名前、生年月日を更新
     * @pass 暗号化されたパスワード
     * @name ユーザ名
     * @birth_date　生年月日
     *
     * */
    public static void findByEncrypt(String id, String passConf, String name, String birthDate) {
    	   Connection conn = null;
           try {
               // データベースへ接続
               conn = DBManager.getConnection();

               // UPDATE文を準備
               String sql = "UPDATE user SET  passConf = ?, name = ?, birthDate = ? WHERE id = ? ";

                // UPDATEを実行し、結果表を取得
               PreparedStatement pStmt = conn.prepareStatement(sql);
               pStmt.setString(1, passConf );
               pStmt.setString(2, name);
               pStmt.setString(3, birthDate);
               pStmt.setString(4, id);

               // UPDATEを実行
               pStmt.executeUpdate();


           } catch (SQLException e) {
               e.printStackTrace();

           } finally {
               // データベース切断
               if (conn != null) {
                   try {
                       conn.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
           }
       }



    public User findByDelete(String id) {//削除
    	 Connection conn = null;
         try {
             // データベースへ接続
             conn = DBManager.getConnection();

             // SELECT文を準備
             String sql = "SELECT * FROM user WHERE id = ?";

              // SELECTを実行し、結果表を取得
             PreparedStatement pStmt = conn.prepareStatement(sql);
             pStmt.setString(1, id);
             ResultSet rs = pStmt.executeQuery();

              // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
             if (!rs.next()) {
                 return null;
             }

             int idDate = rs.getInt("id");
             String loginIdData = rs.getString("login_id");
             String name = rs.getString("name");
             Date birthDate = rs.getDate("birth_date");
             String password = rs.getString("password");
             String createDate = rs.getString("create_date");
             String updateDate = rs.getString("update_date");
             return new User(idDate, loginIdData, name, birthDate, password, createDate, updateDate);

         } catch (SQLException e) {
             e.printStackTrace();
             return null;
         } finally {
             // データベース切断
             if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                     return null;
                 }
             }
         }
     }




    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }
}

