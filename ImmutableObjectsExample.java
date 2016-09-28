/*The following few steps must be considered, when you want any class as an immutable class.

**Class should be marked as final
**All fields must be private and final
**Replace setters with constructor(for assigning a value to a variable).

Lets have a glance what we have typed above*/

//ImmutableClass

public final class ImmutableObjectsExample {

	private final String name;
	private final String address;

	public ImmutableObjectsExample(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	// MainClass from where an ImmutableClass will be called
	public static void main(String[] args) {
		ImmutableObjectsExample example = new ImmutableObjectsExample(
				"John", "San Francisco");
		System.out.println("Name: "+example.getName());
		System.out.println("Address: "+example.getAddress());
	}
}
