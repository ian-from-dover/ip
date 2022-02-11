package lily;

import java.io.IOException;
import java.time.format.DateTimeParseException;

/**
 * Makes sense of commands input by the user and executes them.
 * 
 * @author Hong Yi En, Ian
 * @version Feb 2022 (AY21/22 Sem 2)
 */
public class Parser {
    private final TaskList tasks;
    private final Ui ui;
    private final Storage st;

    /**
     * Creates a new Parser Object.
     * 
     * @param t The TaskList referred to.
     * @param ui The UI needed to interact with the user.
     * @param st The Storage needed to store data.
     */
    public Parser(TaskList t, Ui ui, Storage st) {
        this.tasks = t;
        this.ui = ui;
        this.st = st;
    }

    /**
     * Read's user's input for parsing.
     *
     * @param s The sentence the user had input.
     */
    public void readCommand(String s) {
        parse(s);
    }

    /**
     * The main loop of interacting with the user.
     * Decodes the input and calls the relevant functions.
     */
    public void parse(String sentence) {
        try {
            String[] parsedSentence = sentence.split(" ");
            String command = parsedSentence[0];
            switch (command) {
            case "bye":
                ui.closeUi();
                st.save(tasks);
                break;

            case "list":
                ui.showList(tasks);
                break;

            case "mark":
            // Fallthrough
            case "done":
            // Fallthrough
            case "do":
                int addIdx = Integer.parseInt(parsedSentence[1]); // base 1
                ui.showMarked(tasks.mark(addIdx - 1), addIdx);
                break;

            case "unmark":
                int delIdx = Integer.parseInt(parsedSentence[1]);
                ui.showUnmarked(tasks.unmark(delIdx - 1), delIdx);
                break;

            case "todo":
                ui.showTaskAdded(tasks.addTodo(findTodoDescStart(sentence)), tasks.getSize());
                break;

            case "deadline":
                String[] parsedDeadline = findDeadlineDescStart(sentence);
                ui.showTaskAdded(tasks.addDeadline(parsedDeadline[0], parsedDeadline[1]), tasks.getSize());
                break;

            case "event":
                String[] parsedEvent = findEventDescStart(sentence);
                ui.showTaskAdded(tasks.addEvent(parsedEvent[0], parsedEvent[1]), tasks.getSize());
                break;
    
            case "delete":
            // Fallthrough
            case "remove":
                ui.showTaskRemoved(tasks.remove(
                        Integer.parseInt(parsedSentence[1]) - 1),
                        tasks);
                break;

            case "find":
            // Fallthrough
            case "search":
                if (parsedSentence.length > 2) {
                    throw new LilyException(LilyException.ERROR_TOO_MANY_SEARCH_TERMS);
                } else {
                    ui.showFind(parsedSentence[1], tasks);
                }
                break;
    
            default:
                ui.showInvalidCommand(sentence);
            }

        } catch (LilyException le) {
            ui.showError(le.getMessage());

        } catch (IOException ioe) {
            ui.showError(LilyException.ERROR_WRITE_FILE);

        } catch (IndexOutOfBoundsException oob) {
            // caught when user types "mark, unmark or delete" without giving an index
            // if user types "mark 5" when the list has 2 items, it throws lily exception instead
            ui.showError(LilyException.ERROR_OUT_OF_BOUNDS);

        } catch (NumberFormatException nfe) {
            ui.showError(LilyException.FORMAT_IDX);
        }
    }


    /**
     * Finds the description of the todo in the user's input.
     * 
     * @param s The user's input sentence.
     * @return The description of the todo.
     * @throws LilyException When there is no description.
     */
    private static String findTodoDescStart(String s) throws LilyException {
        try {
            return s.substring(5); // "todo " is 5 char long
        } catch (StringIndexOutOfBoundsException e) {
            throw new LilyException("You gotta tell me what the todo is about!");
        }
    }

    /**
     * Finds the description of the deadline in the user's input.
     * 
     * @param s The user's input sentence.
     * @return The description and date of the deadline.
     * @throws LilyException When there is no description.
     */
    private static String[] findDeadlineDescStart(String s) throws LilyException {
        String[] result = new String[2];
        try {
            result[0] = s.substring(9, s.indexOf("/by") - 1);
            result[1] = s.substring(s.indexOf("/by") + 4);
            return result;
        } catch (StringIndexOutOfBoundsException e) {
            throw new LilyException("You gotta tell me what the deadline is about!");
        }
    }
    
    /**
     * Finds the description of the event in the user's input.
     * 
     * @param s The user's input sentence.
     * @return The description and date of the event.
     * @throws LilyException When there is no description.
     */
    private static String[] findEventDescStart(String s) throws LilyException {
        String[] result = new String[2];
        try {
            result[0] = s.substring(6, s.indexOf("/at") - 1);
            result[1] = s.substring(s.indexOf("/at") + 4);
            return result;
        } catch (StringIndexOutOfBoundsException e) {
            throw new LilyException("You gotta tell me what the event is about!");
        }
    }
}