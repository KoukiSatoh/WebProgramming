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

/**
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

    /**
     * userテーブルにあるIDの値がidであるユーザを取り出すメソッド
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


	/**新規登録が可能かチェックするメソッド
	 * @loginId　	　ログインID
	 * @encPass　　	　暗号化されたパスワード 　
	 * @encPassConf　 暗号化されたパスワード確認　　
	 * @name　　      ユーザ名　
	 * @birthDate    生年月日　
	 * @return パスワード以外が記入済みかつパスワード一致している場合かつログインIDが重複していなければtrueを返す（それ以外はfalse）
	 * 登録、更新日時は表示しないが、保存はするjpsにhiddenで記入しておく
	 * */
	 public boolean siginCheck(String loginId, String encPass, String encPassConf, String name, String birthDate) {
  	   Connection conn = null;

  	   //未入力チェック（未入力があるかないかで分岐　一つでも未入力があれば　falseを返す）
  	   if(loginId.equals("") || encPass.equals("") || encPassConf.equals("")|| name.equals("") ||  birthDate.equals("")) {
  		   //未入力があればfalseを返す
  		   return false;

  	   }else {
  		 //パスワード一致チェック
  		   if(encPass.equals(encPassConf)) {//パスワードが一致しているかで分岐

         try {
             // データベースへ接続
             conn = DBManager.getConnection();

             // INSERT文を準備
             String sql = "INSERT INTO user(login_id, password,name,birth_date,create_date,update_date) VALUES(?,?,?,?,now(),now())";

             
             // INSERT文を実行し、結果表を取得
             PreparedStatement pStmt = conn.prepareStatement(sql);
             pStmt.setString(1, loginId);
             pStmt.setString(2, encPass);
             pStmt.setString(3, name);
             pStmt.setString(4, birthDate);


           // int型で受け取ってINSERT文を実行
           int result = pStmt.executeUpdate();
           //値を受け取れているかチェック
           System.out.println(result+"行");

           return true;


         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         } finally {
             // データベース切断
             if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                     return false;
                 }
             }
         }
             }else {
        	 		return false;
             }
  		 }
	 }


   /**IDとユーザ名と生年月日とを受け取り、ユーザ情報を更新する
    * @param name ユーザ名
    * @param password  パスワード
    * @param birthDate 生年月日
    * @param id ID
    */
    public void findByUpdate(String password,String name,String birthDate, String id ) {//更新
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // UPDATE文を準備
            String sql = "UPDATE user SET  password = ?, name = ?, birth_Date = ? WHERE id = ? ";

             // UPDATEを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, password );
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

    /**暗号化されたパスワード、名前、生年月日を更新
     * @pass 暗号化されたパスワード
     * @name ユーザ名
     * @birth_date　生年月日
     *
     * */
    public void findByEncUpdata(String id, String passConf, String name, String birthDate, String loginId) {
    	   Connection conn = null;
           try {
               // データベースへ接続
               conn = DBManager.getConnection();

               // UPDATE文を準備
               String sql = "UPDATE user SET  passConf = ?, name = ?, birthDate = ?, loginId = ? WHERE id = ? ";

                // UPDATEを実行し、結果表を取得
               PreparedStatement pStmt = conn.prepareStatement(sql);
               pStmt.setString(1, passConf );
               pStmt.setString(2, name);
               pStmt.setString(3, birthDate);
               pStmt.setString(4, loginId);
               pStmt.setString(5, id);


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


    /*ユーザ情報を削除するメソッド
     * @ID id
     * @作成中、SELECTじゃなく、DELETE文を使うはず
     *
    public User findByDelete(String id) {
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
             Date birthDate = rs.getDate("birth_Date");
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
 */



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

