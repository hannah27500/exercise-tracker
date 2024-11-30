/** Exception for when linked list is empty
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/
package model;

public class ListEmptyException extends RuntimeException {
	public ListEmptyException(String message) {
        super(message);
}
}
