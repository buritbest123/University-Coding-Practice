public interface Fixable {
	final String ERROR = "Cannot fix";
	
	boolean fix(int damageLevel);
}

