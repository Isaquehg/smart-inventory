-- Smart Inventory
-- -----------------------------------------------------
-- Schema smart_inventory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `smart_inventory` DEFAULT CHARACTER SET utf8 ;
USE `smart_inventory` ;

-- -----------------------------------------------------
-- Table `smart_inventory`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_inventory`.`Produto` (
  `idProduto` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `peso` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`idProduto`)
);

-- -----------------------------------------------------
-- Table `smart_inventory`.`Proprietario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_inventory`.`Proprietario` (
  `idProprietario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProprietario`)
);

-- -----------------------------------------------------
-- Table `smart_inventory`.`Armazem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_inventory`.`Armazem` (
  `idArmazem` INT NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `Proprietario_idProprietario` INT NOT NULL,
  PRIMARY KEY (`idArmazem`),
  CONSTRAINT `fk_Armazem_Proprietario1`
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
  `Armazem_idArmazem` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  CONSTRAINT `fk_Funcionario_Armazem1`
    FOREIGN KEY (`Armazem_idArmazem`)
    REFERENCES `smart_inventory`.`Armazem` (`idArmazem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table `smart_inventory`.`Armazem_has_Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_inventory`.`Armazem_has_Produto` (
  `Armazem_idArmazem` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  PRIMARY KEY (`Armazem_idArmazem`, `Produto_idProduto`),
  CONSTRAINT `fk_Armazem_has_Produto_Armazem1`
    FOREIGN KEY (`Armazem_idArmazem`)
    REFERENCES `smart_inventory`.`Armazem` (`idArmazem`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Armazem_has_Produto_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `smart_inventory`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
