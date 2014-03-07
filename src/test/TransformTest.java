package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import transform.Transform;

public class TransformTest {

	@Test //ローマ数字単体を数字に変換する処理のテスト
	public void testＭを入力して１０００が返ってくる() {
		Transform transform = new Transform();
		int num = transform.toNum("M");
		assertEquals(1000, num);
	}
	@Test //ローマ数列をリストへ個別に格納するテスト
	public void testローマ数列を入力すると個別に格納されたリストが返ってくる() {
		Transform transform = new Transform();
		ArrayList<String> splitString = transform.strList("VI");
		assertEquals("V", splitString.get(0));
		assertEquals("I", splitString.get(1));
	}
	@Test //ローマ数列リストをアラビア数列リストへ変更するテスト
	public void testローマ数列リストを入力するとアラビア数列リストが返ってくる() {
		Transform transform = new Transform();
		ArrayList<String> testRome = new ArrayList<String>();
		testRome.add("V");
		testRome.add("I");
		ArrayList<Integer> splitString = transform.numList(testRome);
		assertEquals("5", String.valueOf(splitString.get(0)));
		assertEquals("1", String.valueOf(splitString.get(1)));
	}
	@Test //ローマ数列をアラビア数列へ変換する
	public void testローマ数列を入力するとアラビア数列が返ってくる() {
		Transform transform = new Transform();
		String ans = transform.ans("IV");
//		System.out.println(ans);
		assertEquals("4", ans);
	}
	@Test //ローマ数列をアラビア数列へ変換する
	public void testローマ数列ＣＣＣＬＸＩＸを入力するとアラビア数列３６９が返ってくる() {
		Transform transform = new Transform();
		String ans = transform.ans("CCCLXIX");
		System.out.println(ans);
		assertEquals("369", ans);
	}
	@Test //アラビア数列をローマ数列へ変換する
	public void testアラビア数列４を入力するとアラビア数列ＩＶが返ってくる() {
		Transform transform = new Transform();
		String ans = transform.ans("4");
		System.out.println(ans);
		assertEquals("IV", ans);
	}
	@Test //アラビア数列をローマ数列へ変換する
	public void testアラビア数列７８４を入力するとアラビア数列ＤＣＣＬＸＸＸＩＶが返ってくる() {
		Transform transform = new Transform();
		String ans = transform.ans("784");
		System.out.println(ans);
		assertEquals("DCCLXXXIV", ans);
	}
	@Test //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列ＩＩＩＩを入力するとエラーが返ってくる() {
		Transform transform = new Transform();
		String e = transform.ans("IIIII");
		System.out.println(e);
		assertEquals("ローマ数列の書式が不正です。単一の文字は3文字以内で構成しましょう。5の倍数を表す文字は2文字以上続けて表現できません。", e);
	}
	@Test //1と10の倍数を表す文字が２つ以上続いた後にその文字より大きい値を入力するで入力されているとエラーを返す
	public void testローマ数列ＩＩＶを入力するとエラーが返ってくる() {
		Transform transform = new Transform();
		String e = transform.ans("IIV");
		System.out.println(e);
		assertEquals("ローマ数列の書式が不正です。Error001", e);
	}
	@Test //ローマ数儀に変換可能なアラビア数字は１〜３９９９までとなっているかの確認テスト
	public void testアラビア数列のが０を入力したときエラーが返ってくる() {
		Transform transform = new Transform();
		String e = transform.ans("0");
		System.out.println(e);
		assertEquals("ローマ数字はアラビア数字の1〜3999までの範囲のみ処理可能です。", e);
	}
	@Test //ローマ数儀に変換可能なアラビア数字は１〜３９９９までとなっているかの確認テスト
	public void testアラビア数列の値が４０００を入力したときエラーが返ってくる() {
		Transform transform = new Transform();
		String e = transform.ans("4000");
		System.out.println(e);
		assertEquals("ローマ数字はアラビア数字の1〜3999までの範囲のみ処理可能です。", e);
	}
	@Test //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列ＩＭを入力するとエラーが返ってくる() {
		Transform transform = new Transform();
		String e = transform.ans("IM");
		System.out.println(e);
		assertEquals("ローマ数列の書式が不正です。Error002", e);
	}
	@Test //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列とアラビア数列の混合した文字列入力するとエラーが返ってくる() {
		Transform transform = new Transform();
		String e = transform.ans("IV2");
		System.out.println(e);
		assertEquals("入力した数列の書式が不正です。(HINT:ローマ数列は<IVXLCDM>で表現します)", e);
	}
	@Test //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列とアラビ数列の混合した文字列入力するとエラーが返ってくる() {
		Transform transform = new Transform();
		String e = transform.ans("IV2");
		System.out.println(e);
		assertEquals("入力した数列の書式が不正です。(HINT:ローマ数列は<IVXLCDM>で表現します)", e);
	}
}
