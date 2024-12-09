package by.vsu.ist.domain;

import java.util.List;

public class Account extends Entity {
	private String number;
	private String owner;
	private Long balance;
	private boolean active;
	private List<Transfer> transfers;

	public final String getNumber() {
		return number;
	}

	public final void setNumber(String number) {
		this.number = number;
	}

	public final String getOwner() {
		return owner;
	}

	public final void setOwner(String owner) {
		this.owner = owner;
	}

	public final Long getBalance() {
		return balance;
	}

	public final void setBalance(Long balance) {
		this.balance = balance;
	}

	public final boolean isActive() {
		return active;
	}

	public final void setActive(boolean active) {
		this.active = active;
	}

	public List<Transfer> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<Transfer> transfers) {
		this.transfers = transfers;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + getId() +
				", number='" + getNumber() + '\'' +
				", owner='" + getOwner() + '\'' +
				", balance=" + getBalance() +
				", active=" + isActive() +
				'}';
	}
}
