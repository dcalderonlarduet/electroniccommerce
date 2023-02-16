package com.example.electroniccommerce.controller;

import com.example.electroniccommerce.controller.ElectronicCommerceController;
import com.example.electroniccommerce.service.IElectronicCommerceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class ElectronicCommerceControllerTest {

    @Autowired
    ElectronicCommerceController controller;

    @Autowired
    IElectronicCommerceService service;

    private MockMvc mvc;

    private String ENDPOINT = "/electroniccommerce/price";
    private String ENDPOINT_GET_ALL = "/electroniccommerce/allprice";
    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }


    /**
     * Test 1: Petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {

        mvc.perform(
                        get(ENDPOINT)
                                .accept(MediaType.APPLICATION_JSON)
                                .param("applicationDate", "2020-06-14 10:00:00")
                                .param("productId", "35455")
                                .param("brandId", "1"))
                .andExpect(jsonPath("$.price").value(35.5));
    }

    /**
     * Test 2: Petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {

        mvc.perform(
                        get(ENDPOINT)
                                .accept(MediaType.APPLICATION_JSON)
                                .param("applicationDate", "2020-06-14 16:00:00")
                                .param("productId", "35455")
                                .param("brandId", "1"))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    /**
     * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {

        mvc.perform(
                        get(ENDPOINT)
                                .accept(MediaType.APPLICATION_JSON)
                                .param("applicationDate", "2020-06-14 21:00:00")
                                .param("productId", "35455")
                                .param("brandId", "1"))
                .andExpect(jsonPath("$.price").value(35.5));
    }

    /**
     * Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
     *
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {

        mvc.perform(
                        get(ENDPOINT)
                                .accept(MediaType.APPLICATION_JSON)
                                .param("applicationDate", "2020-06-15 10:00:00")
                                .param("productId", "35455")
                                .param("brandId", "1"))
                .andExpect(jsonPath("$.price").value(30.5));
    }

    /**
     * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
     *
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {

        mvc.perform(
                        get(ENDPOINT)
                                .accept(MediaType.APPLICATION_JSON)
                                .param("applicationDate", "2020-06-16 21:00:00")
                                .param("productId", "35455")
                                .param("brandId", "1"))
                .andExpect(jsonPath("$.price").value(38.95));
    }

    @Test
    public void testAllPrices() throws Exception {

        mvc.perform(
                        get(ENDPOINT_GET_ALL)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].brandId").value(1));
    }
}
