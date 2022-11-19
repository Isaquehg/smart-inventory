-- Smart_Inventory
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `smart_inventory` DEFAULT CHARACTER SET utf8 ;
USE `smart_inventory` ;

-- -----------------------------------------------------
-- Table `smart_inventory`.`Proprietario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_inventory`.`Proprietario` (
  `idProprietario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProprietario`)
);

-- -----------------------------------------------------
-- Table `smart_inventory`.`Estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_inventory`.`Estoque` (
  `idEstoque` INT NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `Proprietario_idProprietario` INT NOT NULL,
  PRIMARY KEY (`idEstoque`),
  CONSTRAINT `fk_Estoque_Proprietario1`
    FOREIGN KEY (`Proprietario_idProprietario`)
    REFERENCES `smart_inventory`.`Proprietario` (`idProprietario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table `smart_inventory`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_inventory`.`Funcionario` (
  `idFuncionario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `Estoque_idEstoque` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  CONSTRAINT `fk_Funcionario_Estoque`
    FOREIGN KEY (`Estoque_idEstoque`)
    REFERENCES `smart_inventory`.`Estoque` (`idEstoque`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `smart_inventory`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_inventory`.`Produto` (
  `idProduto` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `peso` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProduto`)
);

-- -----------------------------------------------------
-- Table `smart_inventory`.`Estoque_has_Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_inventory`.`Estoque_has_Produto` (
  `Estoque_idEstoque` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`Estoque_idEstoque`, `Produto_idProduto`),
  CONSTRAINT `fk_Estoque_has_Produto_Estoque1`
    FOREIGN KEY (`Estoque_idEstoque`)
    REFERENCES `smart_inventory`.`Estoque` (`idEstoque`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Estoque_has_Produto_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `smart_inventory`.`Produto` (`idProduto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
