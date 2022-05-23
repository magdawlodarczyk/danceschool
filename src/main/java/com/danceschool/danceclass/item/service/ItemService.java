package com.danceschool.danceclass.item.service;

import com.danceschool.danceclass.item.api.request.ItemRequest;
import com.danceschool.danceclass.item.api.response.ItemResponse;
import com.danceschool.danceclass.item.domain.Item;
import com.danceschool.danceclass.item.repository.ItemRepository;
import com.danceschool.danceclass.item.support.ItemMapper;
import org.springframework.stereotype.Service;


@Service
public class ItemService {
	
	private final ItemRepository itemRepository;
	private final ItemMapper itemMapper;
	
	public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
		this.itemRepository = itemRepository;
		this.itemMapper = itemMapper;
	}

	public ItemResponse create(ItemRequest itemRequest) {
		Item item = itemRepository.save(itemMapper.toItem(itemRequest));
		return itemMapper.toItemResponse(item);
	}
	
	public ItemResponse find(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(RuntimeException::new);
        return itemMapper.toItemResponse(item);
    }
}
