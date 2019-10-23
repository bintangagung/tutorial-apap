package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RestoranController.class)
public class MenuControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("restoranServiceImpl")
    private RestoranService restoranService;

    @MockBean
    @Qualifier("menuServiceImpl")
    private MenuService menuService;

    @Test
    public void whenMenuAddGetFormItShouldSuccessFullyReturnToRightView() throws Exception {
        RestoranModel restoran = generateDummyRestoranModel(1);
        restoran.setIdRestoran(1L);
        when(restoranService.getRestoranByIdRestoran(1L)).thenReturn(Optional.of(restoran));
        mockMvc.perform(get("/menu/add/1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("form-add-menu"))
                .andExpect(content().string(Matchers.containsString("Add Menu")))
                .andExpect(content().string(Matchers.containsString("Add Row")))
                .andExpect(content().string(Matchers.containsString("Delete")))
                .andExpect(content().string(Matchers.containsString("Submit")))
                .andExpect(model().attribute("idRestoran", is(restoran.getIdRestoran())))
                .andExpect(model().attribute("resto", is(restoran)));
    }

    private RestoranModel generateDummyRestoranModel(int count) {
        RestoranModel dummyRestoranModel = new RestoranModel();
        dummyRestoranModel.setNama("dummy " + count);
        dummyRestoranModel.setAlamat("alamat " + count);
        dummyRestoranModel.setIdRestoran((long)count);
        dummyRestoranModel.setNomorTelepon(14000);
        dummyRestoranModel.setListMenu(new ArrayList<>());
        return dummyRestoranModel;
    }

}