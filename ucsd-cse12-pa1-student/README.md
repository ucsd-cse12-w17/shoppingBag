Write your readme here!

1.Bag3 Bag4 Bag8
Bag3 fails my removeNull, itemCount;
Bag4 fails my removeNull;
Bag9 fails my addALot, addDuplicate;

Among the three bags, only bag9 doesn't fail my removeNull test 
because it checks whether the added item is null in its 'add' method 
while bag3 and bag4 don't. Bag9 is also the only one that fail addALot
and addDuplicate because in its itemCount method, it uses '==' to check
whether two items are the same, while bag3 and bag4 use the 'equals'
method in 'item' class. Bag3 fails the 'itemCount' test because it fail
to count an item that is not in the cart as 0 when the cart is non-empty.

2.
Bag0: Bag0 is obviously buggy since it's not implemented.
Bag1: Bag1 is also buggy since its itemCount method uses '==' operation 
which checks whether objects have same reference rather than whether 
they are substantially same, so it fails the addDuplicate test.
Bag2: Bag2 is also buggy as it declares the item array with an initial
size of 10, so when accessing the price of its elements, NullPointerException
occurs.
Bag3: Bag3's itemCount method is buggy because when counting an item that is not
in the cart, but there's other items in the cart, the method fails to give the 
result of 0.
Bag4: Bag4 is not clearly buggy. It uses an arrayList to store all the items.
A new item added will be at the end of the arraylist.
Bag5: Bag5's totalPrice method is buggy since it is always adding the price of
the items at index 1, so it won't be able calculate the total price.
Bag6: Bag6 is obviously buggy since it uses an array of size 10 to store and
manipulate all the item, so when there's more than 10 items,
ArrayIndexOutOfBoundsException easily occurs.
Bag7: Bag7 is buggy with both itemCount and removeAll methods. The bug in
itemCount method is similar to that in Bag1. The removeAll methods always
return false regardless whether there's item removed.
Bag8: Bag8 is also buggy because when we repetitively add and remove item from
the cart, it fails to give the correct count.
Bag9: Bag9 is buggy for similar reason, using the '==' operation rather than
'.equals'.
Bag10: Bag10 is buggy because its removeAll method will remove all the items
in the cart.
Bag11: Bag11 is buggy with its itemCount method. When counting a item that is
not in the cart while there's other item in the cart, the method fails to give
the result of zero. 