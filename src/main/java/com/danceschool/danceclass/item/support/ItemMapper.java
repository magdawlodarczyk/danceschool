package com.danceschool.danceclass.item.support;

import com.danceschool.danceclass.item.api.request.ItemRequest;
import com.danceschool.danceclass.item.api.response.ItemResponse;
import com.danceschool.danceclass.item.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
	
	public Item toItem(ItemRequest itemRequest) {
		return new Item(itemRequest.getName());
	}
	
	
	public ItemResponse toItemResponse(Item item) {
		return new ItemResponse(item.getId(), item.getName());
	}

}
