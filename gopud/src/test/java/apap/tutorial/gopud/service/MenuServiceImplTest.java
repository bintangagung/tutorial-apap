package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();

    @Mock
    MenuDb menuDb;

    private RestoranModel createDummyRestoran(){
        RestoranModel restoran = new RestoranModel();
        restoran.setNama("mekdi");
        restoran.setAlamat("kelapa dua");
        restoran.setNomorTelepon(14045);

        return restoran;
    }

    private MenuModel createDummyMenu(){
        MenuModel menu = new MenuModel();
        menu.setNama("bintang");
        menu.setHarga(BigInteger.valueOf(20000));
        menu.setDurasiMasak(10);
        menu.setDeskripsi("kerensekali");

        return menu;
    }

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave(){
        MenuModel newMenu = createDummyMenu();

        menuService.addMenu(newMenu);

        verify(menuDb, times(1)).save(newMenu);
    }

    @Test
    public void whenDeleteValidMenuItShouldCallMenuRepositoryDelete(){
        MenuModel newMenu = createDummyMenu();

        menuService.addMenu(newMenu);

        menuService.deleteMenu(newMenu);

        verify(menuDb, times(1)).delete(newMenu);
    }

    @Test
    public void whenGetMenuByIdRestoranCalledByExistingDataItShouldReturnCorrectData(){
        RestoranModel restoran = createDummyRestoran();
        restoran.setIdRestoran(1L);
        MenuModel menu = createDummyMenu();
        menu.setId(1L);

        when(menuService.getMenuById(1L)).thenReturn(Optional.of(menu));

        Optional<MenuModel> dataFromServiceCall = menuService.getMenuById(1L);

        verify(menuDb, times(1)).findById(1L);
        assertTrue(dataFromServiceCall.isPresent());

        MenuModel dataFromOptional = dataFromServiceCall.get();

        assertEquals("bintang", dataFromOptional.getNama());
        assertEquals(BigInteger.valueOf(20000), dataFromOptional.getHarga());
        assertEquals(Integer.valueOf(10), dataFromOptional.getDurasiMasak());
        assertEquals("kerensekali", dataFromOptional.getDeskripsi());
    }

    @Test
    public void whenGetMenuListByIdRestoranCalledItShouldReturnAllMenu(){
        RestoranModel restoranModel = createDummyRestoran();
        restoranModel.setIdRestoran(1L);
        List<MenuModel> allMenuInRestoran = new ArrayList<>();
        for(int loopTimes = 3; loopTimes > 0; loopTimes--){
            allMenuInRestoran.add(new MenuModel());
        }
        when(menuService.findAllMenuByIdRestoran(1L)).thenReturn(allMenuInRestoran);

        List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(1L);
        assertEquals(3, dataFromServiceCall.size());

        verify(menuDb, times(1)).findByRestoranIdRestoran(1L);
    }

    @Test
    public void whenChangeMenuCalledItShouldChangeMenuData(){
        MenuModel updatedData = createDummyMenu();
        updatedData.setId((long)1);
        updatedData.setDeskripsi("goodjob");

        when(menuDb.findById(1L)).thenReturn(Optional.of(updatedData));

        when(menuService.changeMenu(updatedData)).thenReturn(updatedData);

        MenuModel dataFromServiceCall = menuService.changeMenu(updatedData);

        assertEquals("bintang", dataFromServiceCall.getNama());
        assertEquals(BigInteger.valueOf(20000), dataFromServiceCall.getHarga());
        assertEquals(Integer.valueOf(10), dataFromServiceCall.getDurasiMasak());
        assertEquals("goodjob", dataFromServiceCall.getDeskripsi());
    }

    @Test
    public void whenChangeMenuCalledButErrorItShouldInvokeNull(){
        MenuModel updatedData = null;

        assertEquals(null, menuService.changeMenu(updatedData));
    }

}
