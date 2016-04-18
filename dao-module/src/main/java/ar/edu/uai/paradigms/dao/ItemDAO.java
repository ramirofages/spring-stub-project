package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.item.Item;
import ar.edu.uai.model.item.ItemCriteria;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skeith on 17/04/2016.
 */
public class ItemDAO implements PersistentDAO<Item, Integer, ItemCriteria>
{
    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Item create(Item item) {
        this.entityManager.persist(item);
        return item;
    }

    @Override
    public Item retrieve(Integer id) {
        return this.entityManager.find(Item.class, id);
    }

    @Override
    public Item update(Item item) {
        return this.entityManager.merge(item);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(this.retrieve(id));
    }

    @Override
    public List<Item> retrieveByCriteria(ItemCriteria itemCriteria) {
        return new ArrayList<Item>();
    }
}
