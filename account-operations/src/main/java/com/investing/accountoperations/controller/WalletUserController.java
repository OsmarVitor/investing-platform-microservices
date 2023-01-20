package com.investing.accountoperations.controller;

import com.investing.accountoperations.domain.model.DTO.DepositDTO;
import com.investing.accountoperations.domain.model.DTO.TransferDTO;
import com.investing.accountoperations.domain.model.Extract;
import com.investing.accountoperations.domain.service.impl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/wallet")
public class WalletUserController {

    @Autowired
    private WalletServiceImpl walletService;

//    @PostMapping("/deposit")
//    public ResponseEntity<Extract> deposit(@RequestBody DepositDTO depositDTO) {
//        Extract extract = walletService.deposit(depositDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(extract);
//    }
//
//    @PostMapping("/withdrawn")
//    public ResponseEntity<Extract> withdrawn (@RequestBody WithdrawnDTO withdrawnDTO) {
//        Extract extract = walletService.withdrawn(transferDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(extract);
//    }
//
//    @PostMapping("/transfer")
//    public ResponseEntity<Extract> transfer (@RequestBody TransferDTO transferDTO) {
//        Extract extract = walletService.transfer(transferDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(extract);
//    }
//
//    @GetMapping("/extract/{userId}")
//    public ResponseEntity<List<Extract>> extract(@PathVariable Long userId) {
//        return ResponseEntity.status(HttpStatus.OK).body(walletService.getExtract(userId));
//    }
}
