package model_classes;

import java.util.Objects;

public class CompanyModel {
	public String name;
	public String catchPhrase;
	public String bs;

	public CompanyModel(String name, String catchPhrase, String bs) {
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		CompanyModel other = (CompanyModel) obj;
		return Objects.equals(name, other.name) && Objects.equals(catchPhrase, other.catchPhrase)
				&& Objects.equals(bs, other.bs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, catchPhrase, bs);
	}
}