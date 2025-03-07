package com.isge.ic3.webServiceRestoTRIANDE.service;

import com.isge.ic3.webServiceRestoTRIANDE.model.Menu;
import com.isge.ic3.webServiceRestoTRIANDE.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu non trouvé"));
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, Menu menu) {
        Menu existingMenu = getMenuById(id);
        existingMenu.setNom(menu.getNom());
        existingMenu.setPlats(menu.getPlats());
        return menuRepository.save(existingMenu);
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}