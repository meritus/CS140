package testers;

import demesnes.Chamber;
import demesnes.Direction;
import demesnes.Location;
import demesnes.Wall;

public class DemesnesTester
{
  
  /**
   * Constructor for Tester
   * Note that there are no instance variables to initialize
   */
  public DemesnesTester()
  {
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
    DemesnesTester tester = new DemesnesTester();
    tester.testWall();
        
    System.out.println();
    tester.testDirection();
    
    System.out.println();
    tester.testLocation();
    
    System.out.println();
    tester.testChamber();
  }
    
  private void testWall()
  {
    System.out.println("\nDisplay state encapsulated by each of this enum's " +
      "constants");
    System.out.println("and exercise each constant's predicate method");
    for (Wall w : Wall.values())
    {
      System.out.println(w.toString() + "\tHas Door?  " +  w.hasDoor());
    }
  }
  
  private void testDirection()
  {
    System.out.println("\nDisplay state encapsulated by each of this enum's " +
      "constants");
    System.out.println("and exercise each constant's accessor methods");
    for (Direction d : Direction.values())
    {
      System.out.println(d.toString() + 
        "\tNext = " + d.next());
    } 
    System.out.println();
    for (Direction d : Direction.values())
    {
      System.out.println(d.toString() + 
        "\tOpposite = " + d.opposite() );
    }  
    System.out.println();
    for (Direction d : Direction.values())
    {
      System.out.println(d.toString() + 
        "\tHoriz Offset = " + d.getHorizontalOffset() +
        "\tVert Offset = " + d.getVerticalOffset());
    }  
  }
  
  private void testLocation()
  {
    System.out.println("Create default location at the origin " +
    		"(i.e., entrance chamber) and display its coordinates");
    Location origin = new Location(); 
    System.out.println(origin + 
      "\tCol = " + origin.getColumn() + 
      ", Row = " + origin.getRow()  + 
      "\tIs this location of origin?  " + origin.isOrigin());
    System.out.println("Is origin = origin?  " + origin.equals(origin)+ "\n");
    
    
    for (Direction d : Direction.values())
    {
      System.out.printf("\nCreate a neighboring location to the %s of the " +
      	"origin location", d);
      Location neighbor = new Location(origin, d);  

      System.out.println("\nDisplay state of neighbor");
      System.out.println("Display coordinates of neighbor and exercise " +
      	"predicate");
      System.out.println(neighbor.toString() + 
        "\tCol = " + neighbor.getColumn() + 
        ", Row = " + neighbor.getRow() + 
        "\tIs this location of origin?  " + neighbor.isOrigin());

      System.out.println("\nCreate copy of neighbor using explicit value " +
          "constructor");
        Location explicitCopyNeighbor = new Location(
            neighbor.getColumn(), neighbor.getRow()); 
      System.out.println("Display state of explicit copy neighbor");
      System.out.println("Display coordinates of explicit copy neighbor and " +
      		"exercise predicate");
      System.out.println(explicitCopyNeighbor.toString() + 
        "\tCol = " + explicitCopyNeighbor.getColumn() + 
        ", Row = " + explicitCopyNeighbor.getRow() + 
        "\tIs this location of origin?  " + explicitCopyNeighbor.isOrigin()); 
      
      System.out.println("Is neighbor = explicitCopyNeighbor?  " + 
          neighbor.equals(explicitCopyNeighbor) +
          "\tIs neighbor = origin?  " + 
          neighbor.equals(origin));
      System.out.println("Is explicitCopyNeighbor = neighbor?  " + 
          explicitCopyNeighbor.equals(neighbor)+ 
          "\tIs explicitCopyNeighbor = origin?  " + 
          explicitCopyNeighbor.equals(origin) + "\n");

      System.out.println("Create copy of neighbor using copy constructor"); 
      Location copyNeighbor = new Location(neighbor);
      System.out.println("Display state of copy neighbor");
      System.out.println("Display coordinates of copy neighbor and " +
          "exercise predicate");
      System.out.println(copyNeighbor.toString() + 
        "\tCol = " + copyNeighbor.getColumn() + 
        ", Row = " + copyNeighbor.getRow() + 
        "\tIs this location of origin?  " + copyNeighbor.isOrigin());       
      
      System.out.println("Is neighbor = copyNeighbor?  " + 
                         neighbor.equals(copyNeighbor) +
                         "\tIs neighbor = origin?  " + 
                         neighbor.equals(origin));
      System.out.println("Is copyNeighbor = neighbor?  " + 
                         copyNeighbor.equals(neighbor)+ 
                         "\tIs copyNeighbor = origin?  " + 
                         copyNeighbor.equals(origin) + "\n");
    }
  }
  
  private void testChamber()
  {
    System.out.print("\nCreate default chamber (i.e., entrance chamber " +
    		"at origin) and display its state");
    Chamber entrance = new Chamber();
    System.out.println(entrance);
    
    System.out.println("\nCreate set of chambers using one parameter " +
    	"constructor \n(i.e., given location, create chamber at that location)");
    for (int i = -2; i < 3; i++)
    {
      System.out.printf("%nCreate chamber at column %d and row %d", i, i);
      Chamber chamber = new Chamber(new Location(i, i), -1);
      System.out.printf("%nDisplay chamber's state:  %s", chamber); 
    }
    System.out.println("\n\nCreate set of chambers that abut entrance " +
    		"chamber in all directions");
    for (Direction d : Direction.values())
    {
      System.out.printf("%nCreate and display neighbor to the %s", d);
    	Chamber chamber = new Chamber(
    	  new Location(entrance.getLocation(), d), -1);
      System.out.println(chamber);     	    	
    }
  }
}


