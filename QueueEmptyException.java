/** Exception for when queue is empty
 * @author Hannah Evans
 * @version 1.0
 * @since 1.0
*/
package model;

public class QueueEmptyException extends RuntimeException {
	public QueueEmptyException(String message) {
        super(message);
    }
}
