package bjtu_prepare.learning;

import java.util.Optional;

/**
 * @Title java.util.Optional 学习
 * @Description
 * @Author SuperBin
 * @Date 2020年8月6日
 */
public class Learning_Optional {

	public static void main(String[] args) {

		System.out.println("12".substring(0, 3));
		User user = new User();
		user.setAge("18");
		System.out.println(user.getAge());

		/**
		 * Optional.of(value); Returns an Optional with the specified present
		 * non-null value. value 没有给属性赋值时，输出结果为 null
		 * value 给 null时，第一行就会报空指针异常，所以为了避免 user 为 null，用ofNullable方法
		 */
		Optional<User> optioanlOf = Optional.of(user);
		System.out.println(optioanlOf.isPresent());
		System.out.println(optioanlOf.get().getAge());

		/**
		 * Optional.ofNullable(value); Returns an Optional describing the
		 * specified value, if non-null,otherwise returns an empty Optional.
		 * value 没有给属性赋值时，输出结果为 null
		 * value 给 null时，报java.util.NoSuchElementException: No value present
		 */

		// 避免报空指针方法
		Optional<User> userRight = Optional.ofNullable(user);
		if (userRight.isPresent()) {
			System.out.println(userRight.get().getAge());
		}
	}

	private static class User {

		private String name;

		private String age;

		private String telPhone;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getTelPhone() {
			return telPhone;
		}

		public void setTelPhone(String telPhone) {
			this.telPhone = telPhone;
		}

	}

}
