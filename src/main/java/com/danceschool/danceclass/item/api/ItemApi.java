package com.danceschool.danceclass.item.api;

import com.danceschool.danceclass.item.api.request.ItemRequest;
import com.danceschool.danceclass.item.api.response.ItemResponse;
//import com.danceschool.danceclass.item.domain.Item;
import com.danceschool.danceclass.item.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemApi {
	private final ItemService itemService;
	
	ItemApi(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping
	public ResponseEntity<ItemResponse> create(@RequestBody ItemRequest itemRequest){
		ItemResponse itemResponse = itemService.create(itemRequest);
		return new ResponseEntity<>(itemResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
    @ApiOperation("Find item")
    public ResponseEntity<ItemResponse> find(@PathVariable Long id) {
        ItemResponse itemResponse = itemService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

}
