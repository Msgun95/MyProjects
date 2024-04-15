package myproject.ecommerse.service;

import myproject.ecommerse.model.ItemList;

import java.util.List;

public interface IItemsListService {

    ItemList addItemList(ItemList itemList);
    List<ItemList> getAllItemLists();
    ItemList getItemListById(int id);
    void deleteItemList(int id);
}
