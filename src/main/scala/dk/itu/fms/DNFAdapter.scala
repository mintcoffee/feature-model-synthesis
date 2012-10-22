package dk.itu.fms

import formula.dnf.DNFClause
import gsd.fms.dnf._

import dk.itu.fms.formula.dnf.{DNF => ITUDNF}

import collection.JavaConversions._

object DNFAdapter {
  
  implicit def toITUTerm(term: Term): DNFClause =
    new DNFClause(term.toArray)
  
  implicit def toITUDNF(dnf: DNF): ITUDNF =
    new ITUDNF(dnf map (toITUTerm(_)))

  implicit def toTerm(ituTerm: DNFClause): Term =
    (ituTerm.getLiterals map (_.intValue)).toSet
  
  def orGroups(dnf: DNF, parent: Int): Set[Set[Int]] =
    (dnf.getOrGroups(parent) map (_.map(_.toInt).toSet)).toSet

}