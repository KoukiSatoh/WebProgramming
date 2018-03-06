package common;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;



public class Cryption {

	/**パスワードを暗号化するメソッド
	 * @paramn password
	 * @return result
	 * @return 暗号化されたパスワード
	 * @throws NoSuchAlgorithmException(例外)
	 */

	public static String encrypt(String source) throws NoSuchAlgorithmException{

		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズムの指定
		String algorithm = "MD5";

		//ハッシュ生成処理
		try {
		byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		String result = DatatypeConverter.printHexBinary(bytes);

		//暗号化されたパスワードを返す
		return result;

		}catch(NoSuchAlgorithmException e) {
			System.out.println(e);
			return null;
		}
	}
}

/* encrypt(String password) パスワードを暗号化するメソッド

 throws NoSuchAlgorithmException{　特定の暗号アルゴリズムが要求されたが、環境内で利用できない場合にスローされる

 getInstance　指定されたダイジェスト・アルゴリズムを実装するMessageDigestオブジェクトを返す
 */
