package mir008;

/**
 * @author Kevan Buckley, maintained by Kim Michael Mir
 * @version 3.3, 2021
 */

public class IOSpecialist { //Middleman - Need to divert methods so they call directly to IOLibrary
  public IOSpecialist() {   
  }
  public String getString(){
    return IOLibrary.getString();
  }
}
