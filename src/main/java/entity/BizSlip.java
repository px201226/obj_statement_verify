package entity;

import java.util.HashSet;
import java.util.Set;
import verify.VerifyType;

public class BizSlip extends BaseEntity {

	private String state1;
	private String state2;

	public BizSlip() {

	}

	public BizSlip(String state1, String state2) {
		this.state1 = state1;
		this.state2 = state2;
	}

	@Override
	public Set<VerifyType> verify() {
		Set<VerifyType> results = new HashSet<>();
		if (state1 == null)
			results.add(VerifyType.FIELD_IS_NULL);

		if (state2 == null || state2.equals(""))
			results.add(VerifyType.STRING_IS_NULL);

		return results;
	}
}
