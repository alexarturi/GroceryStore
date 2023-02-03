import java.util.ArrayList;

public class GroceryStore
{
    /** An array of products normally stocked at the grocery store
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private Product[] productsStocked;

    public GroceryStore(Product[] initialInventory)
    {
        productsStocked = initialInventory;
    }

    /** Returns an ArrayList of indices for Product elements in the
     *  productsStocked array that need to be reordered, as described in part (a)
     *  Precondition: min > 0 */
    public ArrayList<Integer> getReorderList(int min)
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i<productsStocked.length; i++){
            if(productsStocked[i].getQuantity()<=min){
                ret.add(i);
            }
        }
        return ret;
    }

    /** Returns true if all products named in shoppingList are available for purchase
     *  and returns false otherwise, as described in part (b)
     *  Precondition: The products named in shoppingList are found exactly once
     *  in the productsStocked array.
     */
    public boolean checkAvailability(ArrayList<String> shoppingList)
    {
        for (String i : shoppingList){
            for (Product t: productsStocked){
                if(t.getName().equals(i)){
                    if(t.getQuantity()==0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public ArrayList<Product> oversized(double weight)
    {
        ArrayList<Product> ret = new ArrayList<Product>();
        for(Product i: productsStocked){
            if(i.getWeight()>weight){
                ret.add(i);
            }
        }
        return ret;
    }

}
