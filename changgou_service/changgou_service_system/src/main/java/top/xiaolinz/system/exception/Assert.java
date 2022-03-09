package top.xiaolinz.system.exception;

/**
 * @author XiaoLin
 * @date 2022/3/10 00:03
 * @blog https://www.xiaolinz.top/
 **/
public class Assert {

	/**
	 * 判断对象是否为空
	 */
	public static boolean objIsNull(Object obj){
		if (obj == null) {
		    return true;
		}
		return false;
	}
}
