package verify;

// 객체 상태 타입들
public enum VerifyType {
	OBJECT_IS_NULL("엔티티가 널입니다"),
	FIELD_IS_NULL("필드가 널입니다"),
	STRING_IS_NULL("String이 널이네유");

	private String message;

	VerifyType(String message) {
		this.message = message;
	}
}
